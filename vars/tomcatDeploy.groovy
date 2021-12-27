def call(ip,IDcredentials,warName){
  
  sshagent(['${IDcredentials}']) {
                   sh "scp -o StrictHostKeyChecking=no target/${warName}.war ec2-user@${ip}:/opt/tomcat8/webapps/"
                   sh "ssh ec2-user@${ip} sudo /opt/tomcat8/bin/shutdown.sh"
                   sh "ssh ec2-user@${ip} sudo /opt/tomcat8/bin/startup.sh"
                  } 
}
