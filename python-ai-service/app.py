from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class LogRequest(BaseModel):
    log: str

@app.post("/analyze")
def analyze_log(request: LogRequest):
    log = request.log

    # TODO: Replace with OpenAI API call
    return {
        "root_cause": "NullPointerException",
        "suggestion": "Check null values and add validations",
        "severity": "HIGH"
    }
