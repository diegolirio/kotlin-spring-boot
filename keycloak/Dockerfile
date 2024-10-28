# FROM quay.io/keycloak/keycloak:latest as builder
# # Enable health and metrics support
# ENV KC_HEALTH_ENABLED=true
# ENV KC_METRICS_ENABLED=true
# # Configure a database vendor
# ENV KC_DB=postgres
# WORKDIR /opt/keycloak
# # for demonstration purposes only, please make sure to use proper certificates in production instead
# RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
# RUN /opt/keycloak/bin/kc.sh build
# FROM quay.io/keycloak/keycloak:latest
# COPY --from=builder /opt/keycloak/ /opt/keycloak/
# # change these values to point to a running postgres instance
# ENV KC_DB=postgres
# ENV KC_DB_URL=<DBURL>
# ENV KC_DB_USERNAME=<DBUSERNAME>
# ENV KC_DB_PASSWORD=<DBPASSWORD>
# ENV KC_HOSTNAME=localhost
# ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]


# Download 
# > https://github.com/keycloak/keycloak/releases/download/24.0.3/keycloak-24.0.3.zip

# FROM centos:centos7
# RUN yum update -y && yum install -y curl unzip
# RUN curl -L -o keycloak-24.0.3.zip https://github.com/keycloak/keycloak/releases/download/24.0.3/keycloak-24.0.3.zip
# RUN unzip keycloak-24.0.3.zip -d /opt
# WORKDIR /opt/keycloak-24.0.3
# CMD ["./bin/kc.sh", "start-dev"]


# FROM openjdk:17-jdk-alpine
# ENV KEYCLOAK_ADMIN=admin
# ENV KEYCLOAK_ADMIN_PASSWORD=admin
# RUN wget -O /tmp/keycloak-24.0.3.zip https://github.com/keycloak/keycloak/releases/download/24.0.3/keycloak-24.0.3.zip
# RUN unzip /tmp/keycloak-24.0.3.zip -d /opt && rm /tmp/keycloak-24.0.3.zip
# WORKDIR /opt/keycloak-24.0.3
# CMD ["./bin/kc.sh", "start-dev"]


FROM repo.intranet.pags/investments-docker-prod-local/stockmarket-base-image:0.0.21
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin
RUN wget -O /tmp/keycloak-24.0.3.zip https://github.com/keycloak/keycloak/releases/download/24.0.3/keycloak-24.0.3.zip
RUN unzip /tmp/keycloak-24.0.3.zip -d /opt && rm /tmp/keycloak-24.0.3.zip
WORKDIR /opt/keycloak-24.0.3
CMD ["./bin/kc.sh", "start-dev"]