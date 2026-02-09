def call(Map config) {

    if (!config.branch || !config.url || !config.credentialsId) {
        error "Missing required parameters: branch, url, credentialsId"
    }

    echo "Checking out repo ${config.url}, branch ${config.branch}"

    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${config.branch}"]],
        userRemoteConfigs: [[
            url: config.url,
            credentialsId: config.credentialsId
        ]]
    ])
}


// def call (Map config){
//     if (config.branch == 'master'){
//         checkout{[
//                     $class: 'GitSCM',
//                     branches: [[name: config.branch]],
//                     userRemoteConfigs: [[url: config.url,
//                     credentialsId: config.credentialsId]]
//    ]}
// }
// else {
//     error "Branch '${config.branch}' is not supported"
//     }
// }