const msgStyle = {
  error: 'color: red; font-weight: bold',
  info: 'color: royalblue; font-weight: bold',
  warn: 'color: orange; font-weight: bold',
  event: 'color: magenta; font-weight: bold',
  reRender: 'color: dimgray; font-weight: bold; font-size:1.5rem',
  useEffectIn: 'color: blueviolet; font-weight: bold',
  funcIn: 'color: indianred; font-weight: bold',
  setCalled: 'color: tomato; font-weight: bold',
  brown: 'color: sienna',
};

const CONSOLE = {
  error: function (msg: string) {
    coloredMsg(msgStyle.error, msg);
  },
  info: function (msg: string) {
    coloredMsg(msgStyle.info, msg);
  },
  warn: function (msg: string) {
    coloredMsg(msgStyle.warn, msg);
  },
  event: function (msg: string) {
    coloredMsg(msgStyle.event, msg);
  },
  reRender: function (msg: string) {
    coloredMsg(msgStyle.reRender, msg);
  },
  brown: function (msg: string) {
    coloredMsg(msgStyle.brown, msg);
  },
  useEffectIn: function (msg: string) {
    coloredMsg(msgStyle.useEffectIn, `useEffectIn -> ${msg}`);
  },
  funcIn: function (msg: string) {
    coloredMsg(msgStyle.funcIn, `function In -> ${msg}`);
  },
  setCalled: function (msg: string) {
    coloredMsg(msgStyle.setCalled, `set **$${msg}** called!`);
  },
};

function coloredMsg(style: string, ...msg: string[]) {
  console.log(`%c${msg}`, style);
}

export default CONSOLE;