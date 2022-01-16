pipeline {
     // master executor should be set to 0
    agent any
    stages {
         stage('Build Jar') {
         steps {
                bat "mvn clean package -DskipTests"                                
         } 
    }
    stage('Build Image') {
         steps {
                bat "docker build -t srinivas111/selenium-docker -f ./Dockerfile ."                                
         } 
    }
    
    stage('Push Image') {
         steps {
               withCredentials([usernamePassword(credentialsId: 'dockerhub' , passwordVariable: 'pass' ,usernameVariable: 'user')]){
                bat "docker login --username=${user} --password=${pass}"
                bat "docker push srinivas111/selenium-docker:latest"  
                }                              
         } 
     }    
  }
}