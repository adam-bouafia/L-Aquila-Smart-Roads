# Stage 1: Build the Angular application
FROM node:16.14-alpine as build

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json
COPY package.json package-lock.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build the Angular application
RUN npm run build --prod

# Stage 2: Serve the application using Nginx
FROM nginx:stable-alpine

# Copy the built application from the previous stage
COPY --from=build /app/dist/LAquila-Smart-Roads-SOSE /usr/share/nginx/html

# Copy the Nginx configuration template
COPY ./docker/ngnix.frontend.conf /etc/nginx/conf.d/ngnix.asr.template

# Expose port 80 and 443
EXPOSE 80 443

# Start Nginx
CMD ["/bin/ash", "-c", "envsubst '$$NGINX_HOST' < /etc/nginx/conf.d/ngnix.asr.template > /etc/nginx/conf.d/default.conf && exec nginx -g 'daemon off;'"]
