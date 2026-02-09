def call (Map config){
    if (config.branch == 'main'){
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