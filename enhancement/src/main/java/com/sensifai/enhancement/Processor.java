/*
 * MIT License
 *
 * Copyright (c)2020 Sensifai
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.sensifai.enhancement;

import android.content.Context;
import android.graphics.Bitmap;

import com.sensifai.enhancement.results.ProcessResult;

public interface Processor<E> {
    /**
     * initialize all requirement object and load model file based on @modelName argument
     * @param context
     * @param modelName The name of the model we intend to use
     * @param device Which hardware to use to perform the process
     * @param numThreads The number of threads to be used for the process
     * @return
     */
    boolean init(Context context, String modelName, Device device, int numThreads);

    /**
     * overrride this method to release all allocation memory and variables
     * @return true if success else return false
     */
    boolean release();

    /**
     * get current context
     * @return current context
     */
    Context getContext();

    /**
     * overrride this method to process given image(s)
     * @param images array of images that want to be process
     * @param orientation orientation of given image
     * @return  a generic list of result
     */
    ProcessResult<E> process(Bitmap[] images, int orientation);
}
