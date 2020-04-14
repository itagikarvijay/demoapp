pipeline {
    agent any
      tools {
        maven 'Maven 3.6.3'
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
            steps {
                sh 'make publish'
            }
        }
    }
}
