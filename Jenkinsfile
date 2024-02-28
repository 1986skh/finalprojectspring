pipeline {
    agent any 

    stages {
        stage('Salutation à tout le monde devops') { 
            steps {
                echo 'Bonjour tout le monde' 
            }
        }
		
		 stage('Début du pipeline ...') { 
            steps {
                echo 'Chargement' 
            }
        }
        

        stage('Création image Docker') { 
            steps {
                sh 'docker build -t gestibanqueimage .'
            }
        }
        
        stage('Lancement Stack Docker-Compose') { 
            steps {
                sh 'docker compose -f Docker-compose.yml up -d'
            }
        }
    }
}

