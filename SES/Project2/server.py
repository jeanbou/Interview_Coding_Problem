from flask import Flask
import sys
app = Flask(__name__)

serverName = sys.argv[1]

@app.route(sys.argv[3])
def hello():
    return serverName

if __name__ == '__main__':
    app.run(port=sys.argv[2])