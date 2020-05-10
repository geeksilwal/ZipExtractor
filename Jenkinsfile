pipeline{
  agent any
  tools { 
        maven 'Maven 3.6.3' 
        jdk 'jdk11' 
    }
  stages{
      stage('Build'){
         steps{
              sh 'mvn clean compile'
            }
      }

      stage('Test'){
        steps{
              sh 'mvn test'
         }
      }

      stage('Deploy'){
        steps{
              sh 'mvn deploy'
           }
      }

  }
}
