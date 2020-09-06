pipeline {
   agent any

   stages {
      stage('checkout') {
          steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '04eff514-e607-4ca0-8eb4-7cccdf994009', url: 'https://github.com/LaneChen0201/oo-bootcamp.git']]])
          }
      }
      stage('build') {
         steps {
            sh 'echo build'
         }
      }
      stage('Test') {
         steps {
            sh './gradlew test'
         }
      }
      stage('Package') {
         steps {
            sh 'echo package'
         }
      }

      stage('Deploy DEV') {
         steps {
            sh 'echo deploy DEV'
         }
      }

      stage('Promote to test environment') {
         steps {
            script {
                input message: 'Included SRs', ok: 'Submit', id : 'documents',
                parameters:[
                    text(name: '需求', defaultValue: 'SR101, SR102, SR103', description: ''),
                ]
            }
            sh 'echo promote to test environment'
         }
      }

      stage('Deploy SIT') {
        steps {
            script {
                CHOICES = ["Fat1", "Fat2", "Fat3"];
                env.YourTag = input  message: 'Please choose environment',ok : 'Deploy',id :'environments',
                parameters:[choice(choices: CHOICES, description: 'Select an environment for this deploy', name: 'ENV')]
            }
            sh 'echo deploy SIT'
         }
      }

      stage('Confirm Version') {
        steps {
            script {
                input message: 'Confirm Version', ok : 'Confirm', id: 'confirm_version',
                parameters:[
                    text(name: '需求', defaultValue: 'SR1\nSR2\nSR3\n', description: ''),
                    text(name: '封板文档', defaultValue: '文档1.txt\n文档2.doc\n封板文档.ppt\n', description: '')
                ]
            }
            sh 'echo confirm version'
         }
      }

      stage('Deploy PROD') {
         steps {
            script {
                input message: 'Included SRs', ok: 'Submit', id : 'documents',
                parameters:[
                    text(name: '需求', defaultValue: 'SR101, SR102, SR103', description: ''),
                ]
            }
            sh 'echo deploy PROD'
         }
      }
   }
}
