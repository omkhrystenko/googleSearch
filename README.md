***googleSearch is test to verify work of searching function on www.google.com page ***
- Project source located in googleSearch.src.test.java devided in two parts:
1)Test - classes and methods that operates with verifying data;
2)Pages - classes and methods that prepare data from web interface for verifying;

- Compiled project files located in googleSearch.target folder
- Restrictions of conservation in GIT repository is in .gitignore folder
- Module config file is googleSearch.iml
- Tesng NG operating XML file is login-test-2-browsers.xml
- Project Object Model (POM), core of work in Maven, xml file, contains information about the project
  and specify project dependencies, plugins, goals, build profiles…,

***For successful launching of googleSearch test you need to install: ***

1) JDK installing on Windows
Step 1. Download JDK from https://www.oracle.com
Step 2. Install JDK and JRE
Step 3. Include JDK's "bin" Directory in the System PATH
Step 4: Verify the JDK Installation

2) Apache Maven installing on Windows (if you want use CMD for launching)
Step 1. Download Apache Maven Binary zip archive from https://maven.apache.org
Step 2. Unarchive downloaded file to C://Program files
Step 3. Add path for "bin" Directory in the System PATH

*** To launch "googleSearch" test from CMD use following comand:
"mvn clean install -DsuiteXmlFile=login-tests-2-browsers.xml"




