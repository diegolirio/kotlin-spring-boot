docker pull registry.springhome.com.br/user-imc:1.0.0
docker-compose -f docker-compose-user.yml down
docker-compose -f docker-compose-user.yml up -d

echo "Done! Acesse http://localhost:8081"