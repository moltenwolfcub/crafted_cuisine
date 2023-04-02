#!/bin/bash
# requires imageMagick
convert -scale 256x256 mangrove_log.png mangrove_bark.png
convert -rotate 45 -background transparent mangrove_bark.png mangrove_bark.png
convert -interpolate Integer -filter point -resize 32x32 mangrove_bark.png mangrove_bark.png
composite -compose Dst_In -gravity center bark_mask.png mangrove_bark.png mangrove_bark.png
convert mangrove_bark.png +repage -crop 16x16+8+8 mangrove_bark.png

