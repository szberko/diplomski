package com.westharrison.enums;

public enum BrowserTypesEnums {

		firefox("firefox"),
		chrome("chrome"),
		safari("safari");
		
		private String browserName;

		private BrowserTypesEnums(String browserName) {
			this.browserName = browserName;
		}

		public String getBrowserName() {
			return browserName;
		}
		
		
}
