FROM openjdk:11
WORKDIR /app
COPY /src .
RUN javac StudentStatistics.java
ENV DIR_PATH=/app/data/patch/AppData \
    DATA_BATCH=/app/data/patch/BatchFiles
VOLUME /app/data/patch
CMD ["java", "StudentStatistics"]

#CMD ["bash"]
