# backened-AI
This repository belongs to all the backend projects related to AI using different technologies.

# AI Log Analyzer (Production Ready)
An intelligent log analysis system built using Spring Boot + Kafka + Python (FastAPI) + LLM APIs to automatically detect, analyze, and explain application errors using AI.

## Overview
AI Log Analyzer processes application logs in real-time, detects anomalies, and provides AI-powered root cause analysis using Large Language Models (LLMs).

## Architecture Diagram
                +----------------------+
                |   Client / UI / API  |
                +----------+-----------+
                           |
                           v
                +----------------------+
                | Spring Boot Service  |
                | (Log Ingestion API)  |
                +----------+-----------+
                           |
                           v
                +----------------------+
                |       Kafka          |
                |  (Message Queue)     |
                +----------+-----------+
                           |
        -----------------------------------------
        |                                       |
        v                                       v
+----------------------+           +----------------------+
| Log Processor        |           | AI Analyzer Service  |
| (Spring Boot)        |           | (Python FastAPI)     |
+----------+-----------+           +----------+-----------+
           |                                      |
           v                                      v
+----------------------+           +----------------------+
| PostgreSQL / Redis   |           |   LLM APIs (OpenAI)  |
| (Storage + Cache)    |           |   Root Cause Engine  |
+----------------------+           +----------------------+

## API workflow
1️⃣ Log Ingestion
Client sends logs via REST API
Endpoint: /api/logs

POST /api/logs
{
  "service": "order-service",
  "level": "ERROR",
  "message": "NullPointerException at line 45"
}

2️⃣ Kafka Publishing
Logs are pushed to Kafka topic: log-events

3️⃣ Log Processing
Consumer reads logs
Performs:
Filtering (ERROR/WARN)
Enrichment (timestamp, service metadata)

4️⃣ AI Analysis
Processed logs sent to Python FastAPI service
FastAPI calls LLM API to:
Detect issue
Suggest fix
Provide root cause

5️⃣ Response Storage
Results stored in:
PostgreSQL (history)
Redis (quick access)

6️⃣ Result Retrieval API
GET /api/logs/{id}/analysis

Response:
{
  "issue": "Null pointer due to uninitialized object",
  "root_cause": "Object not injected properly",
  "suggestion": "Check dependency injection configuration"
}

## Tech Stack
- Spring Boot (Java)
- FastAPI (Python)
- PostgreSQL
- Redis
- Kafka
- Docker

## Features
- Log ingestion
- AI-based analysis
- Microservices architecture
- Scalable design

⚡ Key Features
✅ Real-time log processing using Kafka
✅ AI-powered root cause analysis
✅ Scalable microservices architecture
✅ Caching with Redis for fast responses
✅ Extensible for multiple services

🚀 How to Run
1. Start Kafka & DB
docker-compose up -d
2. Run Spring Boot Service
mvn spring-boot:run
3. Run Python AI Service
cd ai-service
uvicorn main:app --reload

📌 Future Enhancements
🔹 Add alerting (Slack/Email)
🔹 Dashboard (React UI)
🔹 ML-based anomaly detection
🔹 Multi-tenant support

👨‍💻 Author
Vishal Kumar
Senior Backend Engineer | Microservices | AI Enthusiast
