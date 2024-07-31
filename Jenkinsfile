pipeline {
    agent any
    parameters {
        choice(name: 'BROSWER', choices: ['chrome', 'edge', 'firefox'], description: 'Selecciona el navegador para ejecutar las pruebas')
    }
    stages {
        stage('Prepare environment') {
            steps {
                sh 'env | sort'
                sh 'docker system df'
                sh "docker compose --project-name ${BUILD_TAG} up -d --quiet-pull"
                sh 'docker ps -a'
                sh 'docker network ls'
            }
        }
        stage('End2End Tests') {
            steps {
                sh 'sleep 20s'
                sh "docker run --rm -v ${WORKSPACE}:/usr/src/app -w /usr/src/app --network ${BUILD_TAG}_default maven:3.8.8-eclipse-temurin-17 mvn clean verify -B -ntp -Dwebdriver.remote.url=http://${BUILD_TAG}-selenium-hub-1:4444/wd/hub -Dwebdriver.remote.driver=${BROSWER}"
                publishHTML(
                    target: [
                        reportName           : 'Serenity Report',
                        reportDir            : 'target/site/serenity',
                        reportFiles          : 'index.html',
                        keepAll              : true,
                        alwaysLinkToLastBuild: true,
                        allowMissing         : false
                    ]
                )
            }
        }
    }
    post {
        always {
            sh "docker compose --project-name ${BUILD_TAG} down --rmi all --volumes"
            sh 'docker system df'
            cleanWs()
        }
    }
}
