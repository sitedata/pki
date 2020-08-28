#common to all subsystems
MASTER_HOSTNAME = 'pki1.example.com'
CLONE_HOSTNAME = 'pki2.example.com'

CLIENT_PKCS12_PASSWORD = 'SECret.123'
CLIENT_DIR_PASSWORD = 'SECret.123'
BACKUP_PASSWORD = 'SECret.123'
CLIENT_DATABASE_PASSWORD = 'SECret.123'
NSSDB = '/opt/pki/certdb'
ROOT_CA_CERT_PATH = '/tmp/rootCA.pem'

#CA Instance
CA_HTTPS_PORT = 'capki_https_port'
CA_HTTP_PORT = 'capki_http_port'
CA_AJP_PORT = 'capki_ajp_port'
CA_TOMCAT_PORT = 'capki_tomcat_port'
CA_CLIENT_DIR = '/opt/topology-CA'
CA_INSTANCE_NAME = 'topology-CA'
SECURITY_DOMAIN_PASSWORD = 'SECret.123'
CA_PASSWORD = 'SECret.123'
CA_SECURITY_DOMAIN_NAME = 'topology_Foobarmaster.org'
CA_ADMIN_USERNAME = 'caadmin'
CA_ADMIN_NICK = 'PKI CA Administrator for Example.Org'
#KRA Instance
KRA_INSTANCE_NAME = 'topology-KRA'
KRA_HTTPS_PORT = 'krapki_https_port'
KRA_HTTP_PORT = 'krapki_http_port'
KRA_AJP_PORT = 'krapki_ajp_port'
KRA_TOMCAT_PORT = 'krapki_tomcat_server_port'
KRA_PASSWORD = 'SECret.123'
KRA_CLIENT_DIR = '/opt/topology-KRA'
KRA_ADMIN_NICK = 'PKI KRA Administrator for Example.Org'
KRA_ADMIN_USERNAME = 'kraadmin'
#OCSP Instance
OCSP_INSTANCE_NAME = 'topology-OCSP'
OCSP_HTTPS_PORT = 'ocsppki_https_port'
OCSP_HTTP_PORT = 'ocsppki_http_port'
OCSP_AJP_PORT = 'ocsppki_ajp_port'
OCSP_TOMCAT_PORT = 'ocsppki_tomcat_server_port'
OCSP_PASSWORD = 'SECret.123'
OCSP_CLIENT_DIR = '/opt/topology-OCSP'
OCSP_ADMIN_NICK = 'PKI OCSP Administrator for Example.Org'
OCSP_ADMIN_USERNAME = 'ocspadmin'
#TKS Instance
TKS_INSTANCE_NAME = 'topology-TKS'
TKS_HTTPS_PORT = 'tkspki_https_port'
TKS_HTTP_PORT = 'tkspki_http_port'
TKS_AJP_PORT = 'tkspki_ajp_port'
TKS_TOMCAT_PORT = 'tkspki_tomcat_server_port'
TKS_PASSWORD = 'SECret.123'
TKS_CLIENT_DIR = '/opt/topology-TKS'
TKS_ADMIN_NICK = 'PKI TKS Administrator for Example.Org'
TKS_ADMIN_USERNAME = 'tksadmin'
#TPS instance
TPS_INSTANCE_NAME = 'topology-TPS'
TPS_HTTPS_PORT = 'tpspki_https_port'
TPS_HTTP_PORT = 'tpspki_http_port'
TPS_AJP_PORT = 'tpspki_ajp_port'
TPS_TOMCAT_PORT = 'tpspki_tomcat_server_port'
TPS_PASSWORD = 'SECret.123'
TPS_CLIENT_DIR = '/opt/topology-TPS'
TPS_ADMIN_NICK = 'PKI TPS Administrator for Example.Org'
TPS_ADMIN_USERNAME = 'tpsadmin'
#LDAP Details
LDAP_PORT = 'ldapServerPort'
LDAPS_PORT = 'ldapSecureServerPort'
LDAP_SECURE_CON_PEM_FILE = 'ldapSecreConPemFile'
LDAP_BIND_DN = 'cn=Directory Manager'
LDAP_PASSWD = 'SECret.123'
LDAP_BASE_DN = 'dc=example,dc=org'
LDAP_KRA_PORT = 'ldapkraServerPort'
LDAP_OCSP_PORT = 'ldapocspServerPort'
LDAP_TKS_PORT = 'ldaptksServerPort'
LDAP_TPS_PORT = 'ldaptpsServerPort'
LDAP_USER = 'foobar'
LDAP_USER_ENROLL = 'testuser'
CUID = '40906145C76224192D2B'
CUID_01 = '40906145C76224192D11'
TPS_OPERATION = 'ra_enroll'
#Details for tps-activity cli automation
LDAP_USER1 = 'jdoe'
TOKEN_FORMAT = 'ra_format'
TOKEN_RESET_PIN = 'ra_reset_pin'
TOKEN_CUID = '40000000000000000002'


# SubCA details
SUBCA_INSTANCE_NAME = 'topology-SubCA'
SUBCA_CA_INSTANCE_NAME = 'topology-CA'
SUBCA_KRA_INSTANCE_NAME = 'topology-KRA'
SUBCA_HTTPS_PORT = 'subpki_https_port'
SUBCA_HTTP_PORT = 'subpki_http_port'
SUBCA_AJP_PORT = 'subpki_ajp_port'
SUBCA_TOMCAT_PORT = 'subpki_tomcat_port'
SUBCA_PASSWORD = 'SECret.123'
SUBCA_KRA_HTTPS_PORT = '19443'
SUBCA_KRA_HTTP_PORT = '19080'
SUBCA_KRA_AJP_PORT = '19009'
SUBCA_KRA_TOMCAT_PORT = '19005'
SUBCA_ADMIN_NICK = 'PKI Administrator for example.com'
SUBCA_SECURITY_DOMAIN_NAME = 'SUBORDINATE'


PROTOCOL_SECURE = 'https'
PROTOCOL_UNSECURE = 'http'
ACME_CONFIG_PATH = '/usr/share/pki/acme'
