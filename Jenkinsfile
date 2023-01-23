pipeline {
    agent any

    tools {
        jdk "JDK 11"
        maven "Maven 3.8.7"
    }

    stages {
        stage('Git checkout') {
            steps {
                echo "BUILD_NUMBER=${env.BUILD_NUMBER}"

                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'jenkins-user-github', url: 'https://github.com/SameeraGrandhi/StarwarsAPIIntegration.git']]])
                sh "ls -lart ./*"

                archiveArtifacts artifacts: '*', fingerprint: true
            }
        }
        stage('maven build') {
            steps {
                echo "Building repository with maven"
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('deploy containers') {
            steps {
                withEnv(["PATH=$PATH:/usr/local/bin/"]) {
                    sh 'printenv'
                    sh 'pwd'
                    sh 'docker-compose up --build -d'
                }
            }
        }
    }
}