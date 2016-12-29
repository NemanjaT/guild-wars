var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
  entry: {
    home: ['./app/app.ts', './style/main.less']
  },
  devtool: 'source-map',
  output: {
    filename: 'js/global.min.js',
    path: '../../guild-wars-web/src/main/webapp/WEB-INF/lib'
  },
  resolve: {
    extensions: ['', '.webpack.js', '.web.js', '.ts', '.js']
  },
  module: {
    loaders: [
      {test: /\.ts$/, loader: 'ts-loader'},
      {test: /\.less$/, loader: ExtractTextPlugin.extract('style-loader', 'css-loader!less-loader')}
    ]

  },
  plugins: [
    new ExtractTextPlugin('css/style.min.css', {allChunks: true}),
    new webpack.optimize.UglifyJsPlugin({minimize: true})
  ]
};
