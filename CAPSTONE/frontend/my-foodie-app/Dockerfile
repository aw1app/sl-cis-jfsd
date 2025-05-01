FROM node:18-alpine AS builder
WORKDIR /app
COPY . .
RUN npm install && npm run build --omit=dev

FROM nginx:alpine
COPY --from=builder /app/dist/my-foodie-app /usr/share/nginx/html
