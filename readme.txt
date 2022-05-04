Hook-based E2E Testing Framework

To configure it on your own web application, follow these steps:

1) Create the "envForGithubActions" virtual environment in Github

2) Insert the following 9 environment variables, customizing the example values shown here according to your application under test:
BRANCH_NAME: master
DIR_FILE_FE: /home/runner/work/Tesi-AngularProject/Tesi-AngularProject/WebAppHooks/angular-java-example-master/src/main/ui/src/app/*.html
EMAIL_ACCOUNT_GITHUB: t*********@gmail.com
NOME_ACCOUNT_GITHUB: g*********
PASSWORD_ACCOUNT_GITHUB: *********
GRAMMAR_TYPE: angularjs
NUMERO_SPLIT: 1
PATH_REPOSITORY: /home/runner/work/Tesi-AngularProject/Tesi-AngularProject
MIN_EXE_TEST: 5

DIR_FILE_FE is the folder of the web app recursively containing Web templates
NOME_ACCOUNT_GITHUB is the name of the Github user. Github credentials are needed to allow to the yamls scripts to upload application refactorings updates and test results
Supported GRAMMAR_TYPE values: angularjs, smarty, twig, freemarker
NUMERO_SPLIT is currently unused
PATH_REPOSITORY is the path on the cloud machine that will contains the checkout of the web app
MIN_EXE_TEST is the timeout time (in seconds) for test case execution. Shorter value may cause the failure of test cases for slow rendered Web applications

3) Replace the "insert-here-your-web-app" folder on this repository with a folder containing your web application project

4) Customize the startBackEnd.sh and startFrontEnd.sh files, based on your application under test, in order to consider preconditions and dependencies.
For example:

startBackEnd.sh:
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master
mvn clean install
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master/target
echo "Listing of jarfiles in the target folder"
ls -a
java -jar users-0.0.1-SNAPSHOT.jar

startFrontEnd.sh:
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master/src/main/ui
npm install
npm start


N.B. The test files that will be run into the conrainer, must be saved in the folder:
./project-test-headless/src/test/java/com/example/TesiIntegrazioneProgettoEsterno/
