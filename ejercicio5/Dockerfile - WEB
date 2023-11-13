FROM node:18 as build

WORKDIR /app

COPY package.json package-lock.json /app/

RUN npm install -g npm@10.2.3

RUN npm install -g @angular/cli@16.2.9 typescript@4.9.3

COPY . /app/

WORKDIR /app/gestion-empleados-frontend

RUN ng build --configuration=production

FROM nginx:alpine

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]
