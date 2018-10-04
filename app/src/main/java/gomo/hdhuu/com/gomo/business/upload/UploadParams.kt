package gomo.hdhuu.com.gomo.business.upload

import com.google.firebase.storage.StorageReference
import java.io.File

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
class UploadParams(val reference: StorageReference,
                   val password: String,
                   val file: File,
                   val byteArray: ByteArray,
                   val inputType: Int)
