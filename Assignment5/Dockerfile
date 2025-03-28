# Use OpenJDK as the base image
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project directory to the container
COPY ../../ /app

# Ensure the bin and Lib directories exist
RUN mkdir -p bin Lib

# Compile Java files and store class files in 'bin' directory
RUN javac -d bin src/application5/*.java

# Run the application with PostgreSQL JDBC driver in classpath
CMD ["java", "-cp", "bin:Lib/postgresql-42.7.4.jar", "application5.TestApp5"]
