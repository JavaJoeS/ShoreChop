/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.buildinit.tasks;

import java.io.File;
import java.util.Optional;
import java.net.URI;
import org.gradle.wrapper.Logger;

public enum DistributionUrlAction {
    PULL;
	public String getUrl() {
		Logger logger = new Logger(false);
		
		//System.getProperties().forEach((key, value) -> logger.log(key + " : " + value));
		String targetDistributionUrl = null;
		try {
	    	Optional<String>evoDistributionUrl = Optional.ofNullable(
	    			System.getProperty("evoDistributionUrl"));
	    	if ( evoDistributionUrl.isPresent() ) {
	    		targetDistributionUrl = evoDistributionUrl.get();
	    	} else {
	    		targetDistributionUrl ="https://github.com/JavaJoeS";
	    	}
	    	logger.log("DistributionUrlAction - VALUE:"+targetDistributionUrl);
		} catch (NullPointerException npe) {
			logger.log("DistributionUrlAction - FAILED to get VALUE:"+npe );
			targetDistributionUrl ="https://github.com/JavaJoeS";
		}
    	return targetDistributionUrl;
	}
}
