pipeline {
    agent any
      tools {
        maven 'MAVEN363'
        jdk 'JDK8'
    }
    stages {
    	stage ("initialize") {
			steps {
				sh '''
					echo "PATH = ${PATH}"
					echo "M2_HOME = ${M2_HOME}"
				'''
			}
		}	
		stage('Checkout') {
			checkout([$class: 'GitSCM', 
			branches: [[name: '*/master']], 
			doGenerateSubmoduleConfigurations: false, 
			extensions: [], 
			submoduleCfg: [], 
			userRemoteConfigs: [[url: 'https://github.com/itagikarvijay/demoapp.git']]])
		}
        stage('build') {
            steps {
                echo 'Building'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
                echo 'successfull...'
              }
            }
        }
    }
}
