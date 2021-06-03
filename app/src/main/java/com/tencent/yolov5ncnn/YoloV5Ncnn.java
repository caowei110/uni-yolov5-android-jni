// Tencent is pleased to support the open source community by making ncnn available.
//
// Copyright (C) 2020 THL A29 Limited, a Tencent company. All rights reserved.
//
// Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
// in compliance with the License. You may obtain a copy of the License at
//
// https://opensource.org/licenses/BSD-3-Clause
//
// Unless required by applicable law or agreed to in writing, software distributed
// under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
// CONDITIONS OF ANY KIND, either express or implied. See the License for the
// specific language governing permissions and limitations under the License.

package com.tencent.yolov5ncnn;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

public class YoloV5Ncnn
{
    public native boolean Init(AssetManager mgr,
                               String jstride8OutName,
                               String jstride16OutName,
                               String jstride32OutName,
                               String jinputName,
                               int jimgSize,
                               float jprobThreshold,
                               float jnmsThreshold
    );

    public class Obj
    {
        public float x;
        public float y;
        public float w;
        public float h;
        public String label;
        public float prob;
    }
    public static class InitParams{
        public String stride8OutName = "output";
        public String stride16OutName = "781";
        public String stride32OutName = "801";
        public String inputName = "images";
        public int imgSize = 640;
        public float probThreshold = 0.25f;
        public float nmsThreshold = 0.45f;
    }

    public native Obj[] Detect(Bitmap bitmap, boolean use_gpu);

    static {
        System.loadLibrary("yolov5ncnn");
    }
}
