# Use the official Node.js image
FROM node:latest as builder

WORKDIR /frontapp

# Install Angular CLI
RUN npm install -g @angular/cli

# Copy the package.json and install dependencies
COPY package.json .
RUN npm install

# Copy the Angular project files and build
COPY . .
RUN ng build --configuration=production

# Use a lightweight web server image for serving the Angular app
FROM nginx:alpine

COPY --from=builder /frontapp/dist/frontapp /usr/share/nginx/html

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]
