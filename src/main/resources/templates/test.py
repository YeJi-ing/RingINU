from flask import Flask, render_template

app = Flask(__name__)

host_addr = "0.0.0.0"
port_num = "8080"
counter=3

@app.route("/")
def show_count():
    return render_template("index.html", counter)

if __name__ == "__main__":
    app.run(host=host_addr, port=port_num)