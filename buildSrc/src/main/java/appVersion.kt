object appVersion {
    val versionMajor = 1
    val versionMinor = 0
    val versionPatch = 0
    val versionBuild = 0
    val minSdkVersion = Config.minSdkVersion
    fun generateVersionCode() : Int = versionMajor * 10000 + versionMinor * 100 + versionPatch + versionBuild
    fun generateVersionName() : String = "${versionMajor}.${versionMinor}.${versionPatch}"
}

/* prev play store live versio
*
    val versionMajor = 1
    val versionMinor = 1
    val versionPatch = 1
    val versionBuild = 3
* */