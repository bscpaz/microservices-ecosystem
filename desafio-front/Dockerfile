FROM node:21 AS builder

RUN npm install -g @angular/cli

WORKDIR /app

COPY package*.json /app/

RUN npm install --force

COPY . /app/

ARG CONFIGURATION=production
RUN echo "Configuração escolhida: '$CONFIGURATION'" 

RUN ng build --base-href . --configuration=$CONFIGURATION

#------------------------------------------------------
FROM nginx:1.25.3

WORKDIR /usr/share/nginx/html

COPY --from=builder /app/dist .
RUN mv ./desafio-front ./desafio
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
