Create fork Notification Service

## Single stage - Build only
```shell
docker build --no-cache -t notification:1.0 -f docker/build/Dockerfile .

# Run for debugging:
docker run -it --rm --name notification notification:1.0 bash
# ls -al
# ls target -al

# Observe the image size of notification after containerizing
docker images
```

## Multiple stages - Build and package
```shell
# Perform containerization
docker build --no-cache -t notification:1.0 \
  --build-arg ENVIRONMENT=develop \
  --build-arg APP_NAME=notification \
  --build-arg APP_PORT=80 \
  -f docker/multi-stages/Dockerfile .
  
# Run the application:
docker run -d --name notification notification:1.0
docker logs notification -t

# Run for debugging:
docker run -it --rm --name notification-debugging notification:1.0
docker run -it --rm --name notification-debugging notification:1.0 echo Hello World!

# Observe the image size of notification after containerizing:
docker images

# Observe the container info of application
docker inspect notification
# Looking at: Env, Args
```