var path = require('path');

module.exports = {
  context: __dirname,
  entry: "./frontend/tour_guide.jsx",
  output: {
    path: path.resolve(__dirname),
    filename: "bundle.js"
  },
  module: {
    loaders: [
      {
        test: [/\.jsx?$/, /\.js?$/],
        exclude: /(node_modules)/,
        loader: 'babel-loader',
        query: {
          presets: ['env', 'react']
        }
      }, {
        test: /\.scss$/,
        loaders: ['style-loader', 'css-loader', 'sass-loader']
      }, {
         test: /.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
         use: [{
           loader: 'file-loader',
           options: {
             name: '[name].[ext]',
             outputPath: './assets/font/',
             publicPath: '../'       // override the default path
           }
         }]
       },
    ]
  },
  
  devtool: 'source-map',
  resolve: {
    extensions: [".js", ".jsx", "*"]
  }
};
