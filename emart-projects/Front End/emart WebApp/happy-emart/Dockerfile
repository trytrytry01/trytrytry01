FROM nginx:1.13.3-alpine
COPY nginx/default.conf /etc/nginx/conf.d/
COPY dist/happy-emart /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]