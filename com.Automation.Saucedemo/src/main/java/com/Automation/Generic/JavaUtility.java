package com.Automation.Generic;

import java.time.LocalDateTime;

public class JavaUtility {
	public String date_time() {
		String value = LocalDateTime.now().toString().replace(":", "").replace("-", "").replace(".", "");
		return value;
	}

}
