"# AndroidHiddenCameraServer" 





android {

    packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
    }
}

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.smzh745:AndroidHiddenCameraServer:v1.0'
	}


