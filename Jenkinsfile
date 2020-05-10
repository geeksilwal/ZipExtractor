pipeline{
  agent any
  tools { 
        maven 'maven_3_6_3' 
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
