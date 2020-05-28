import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {ReserveComponent} from "../reserve/reserve.component";

export class WebSocket {
  webSocketEndPoint: string = 'http://localhost:8080/api';
  topic: string = "/topic/seats";
  stompClient: any;
  constructor(private reserveComponent: ReserveComponent){
  }
  _connect() {
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    const _this = this;
    _this.stompClient.connect({}, function (frame) {
      _this.stompClient.subscribe(_this.topic, function (sdkEvent) {
        _this.onMessageReceived(sdkEvent);
      });
      //_this.stompClient.reconnect_delay = 2000;
    }, this.errorCallBack);
  };

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log("Disconnected");
  }

  // on error, schedule a reconnection attempt
  errorCallBack(error) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  /**
   * Send message to sever via web socket
   * @param {*} message
   */
  _send(message) {
    console.log("calling logout api via web socket");
    this.stompClient.send("/app/getSeats", {}, JSON.stringify(message));
  }

  onMessageReceived(message) {
    console.log("Message received from server :: " + typeof (message));
    this.reserveComponent.handleMessage(JSON.parse(message.body));
  }
}
