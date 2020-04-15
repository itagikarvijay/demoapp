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
		stage('Checkout code') {
	        steps {
	        	echo 'CheckingOut'
	            git credentialsId: 'repoPassword', url: 'https://github.com/itagikarvijay/demoapp.git'
	        }
    	}
			
        stage('build') {
            steps {
                echo 'Building'
                mvn clean verify
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
