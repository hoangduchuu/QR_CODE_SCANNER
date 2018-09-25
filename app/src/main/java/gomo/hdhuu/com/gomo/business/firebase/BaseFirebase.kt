package gomo.hdhuu.com.gomo.business.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
abstract class BaseFirebase {
    val TAG = this.javaClass.simpleName
    protected val mAuth: FirebaseAuth
    protected val mFireDB: FirebaseDatabase
    protected val mRootDB: DatabaseReference
    protected val mUser: FirebaseUser?
    protected val mStorage: FirebaseStorage

    // Create a storage reference from our app
    protected val rootStorageRef: StorageReference

    init {
        mAuth = FirebaseAuth.getInstance()
        mFireDB = FirebaseDatabase.getInstance()
        mRootDB = mFireDB.reference
        this.mUser = FirebaseAuth.getInstance().currentUser
        this.mStorage = FirebaseStorage.getInstance()
        this.rootStorageRef = mStorage.getReference()

        mRootDB.keepSynced(true)
    }


    protected fun getParkingRef(ownerUuid: String, parkingUuid: String): StorageReference {
        return rootStorageRef.child(ownerUuid).child(parkingUuid)
    }

    protected fun getParkingRef(ownerUuid: String, parkingUuid: String, fileName: String): StorageReference {
        return rootStorageRef.child(ownerUuid).child(parkingUuid).child(fileName)
    }



}