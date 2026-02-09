def call (Map config){
    if (config.branch == 'master'){
        checkout{[
                    $class: 'GitSCM',
                    branches: [[name: config.branch]],
                    userRemoteConfigs: [[url: config.url,
                    credentialsId: config.credentialsId]]
   ]}
}
else {
    error "Branch '${config.branch}' is not supported"
    }
}