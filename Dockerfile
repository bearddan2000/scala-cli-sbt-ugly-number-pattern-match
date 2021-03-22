ARG OPENJDK_TAG=8u232
FROM openjdk:${OPENJDK_TAG}

ARG SBT_VERSION=1.4.5

# Install sbt
RUN \
  mkdir /working/ && \
  cd /working/ && \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  cd && \
  rm -r /working/ && \
  sbt sbtVersion

WORKDIR /tmp

COPY bin/ .

RUN sbt run \
  && sbt package \
  && chmod -R +x target/scala-2.13

CMD ["/usr/bin/scala", "/tmp/target/scala-2.13/user-svc_2.13-0.0.1-SNAPSHOT.jar"]
