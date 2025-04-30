FROM node:18-alpine AS builder
WORKDIR /app
COPY . .
RUN npm install && npm run build --prod

FROM nginx:alpine
COPY --from=builder /app/dist/foodie-app /usr/share/nginx/html
