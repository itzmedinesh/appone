FROM ubuntu:latest
LABEL authors="dineshsubramanian"

ENTRYPOINT ["top", "-b"]