/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;


import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.BindPortVlan;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CloneVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ConvertVMToImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.EjectISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.InsertISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.MigrateVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugNIC;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.RebootVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResumeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SuspendVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnbindPortVlan;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineImpl extends AbstractImpl<VirtualMachine, VirtualMachineList, VirtualMachineSpec> {


	@Override
	public VirtualMachine getModel() {
		return new VirtualMachine();
	}

	@Override
	public VirtualMachineSpec getSpec() {
		return new VirtualMachineSpec();
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	@Override
	public VirtualMachineSpec getSpec(VirtualMachine r) {
		return r.getSpec();
	}

	/**
	 * @param name  name
	 * @throws Exception exception
	 */
	public boolean setHA(String name) throws Exception {
		return this.addTag(name, ExtendedKubernetesConstants.LABEL_VM_HA, String.valueOf(true));
	}
	
	/**
	 * @param name  name
	 * @throws Exception exception
	 */
	public boolean unsetHA(String name) throws Exception {
		return deleteTag(name, ExtendedKubernetesConstants.LABEL_VM_HA);
	}


	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/

	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO) throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO, null);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName, CreateAndStartVMFromISO createAndStartVMFromISO) throws Exception {
		return createAndStartVMFromISO(name, nodeName, createAndStartVMFromISO, null);
	}

	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO, String eventId) throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO, eventId);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName,CreateAndStartVMFromISO createAndStartVMFromISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromISO)));
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage) throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, null);
	}

	public boolean createAndStartVMFromImage(String name, String nodeName, CreateAndStartVMFromImage createAndStartVMFromImage) throws Exception {
		return createAndStartVMFromImage(name, nodeName, createAndStartVMFromImage, null);
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage, String eventId) throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, eventId);
	}

	public boolean createAndStartVMFromImage(String name, String nodeName,CreateAndStartVMFromImage createAndStartVMFromImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromImage)));
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM) throws Exception {
		return resizeRAM(name, resizeRAM, null);
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeRAM);
	}

	public boolean suspendVM(String name, SuspendVM suspendVM) throws Exception {
		return suspendVM(name, suspendVM, null);
	}

	public boolean suspendVM(String name, SuspendVM suspendVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), suspendVM);
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce) throws Exception {
		return stopVMForce(name, stopVMForce, null);
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), stopVMForce);
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice) throws Exception {
		return unplugDevice(name, unplugDevice, null);
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugDevice);
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC) throws Exception {
		return unplugNIC(name, unplugNIC, null);
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugNIC);
	}

	public boolean migrateVM(String name, MigrateVM migrateVM) throws Exception {
		return migrateVM(name, migrateVM, null);
	}

	public boolean migrateVM(String name, MigrateVM migrateVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), migrateVM);
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU) throws Exception {
		return changeNumberOfCPU(name, changeNumberOfCPU, null);
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), changeNumberOfCPU);
	}

	public boolean resumeVM(String name, ResumeVM resumeVM) throws Exception {
		return resumeVM(name, resumeVM, null);
	}

	public boolean resumeVM(String name, ResumeVM resumeVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resumeVM);
	}

	public boolean plugDisk(String name, PlugDisk plugDisk) throws Exception {
		return plugDisk(name, plugDisk, null);
	}

	public boolean plugDisk(String name, PlugDisk plugDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugDisk);
	}

	public boolean plugDevice(String name, PlugDevice plugDevice) throws Exception {
		return plugDevice(name, plugDevice, null);
	}

	public boolean plugDevice(String name, PlugDevice plugDevice, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugDevice);
	}

	public boolean resetVM(String name, ResetVM resetVM) throws Exception {
		return resetVM(name, resetVM, null);
	}

	public boolean resetVM(String name, ResetVM resetVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resetVM);
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk) throws Exception {
		return unplugDisk(name, unplugDisk, null);
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugDisk);
	}

	public boolean stopVM(String name, StopVM stopVM) throws Exception {
		return stopVM(name, stopVM, null);
	}

	public boolean stopVM(String name, StopVM stopVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), stopVM);
	}

	public boolean startVM(String name, StartVM startVM) throws Exception {
		return startVM(name, startVM, null);
	}

	public boolean startVM(String name, StartVM startVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), startVM);
	}

	public boolean deleteVM(String name, DeleteVM deleteVM) throws Exception {
		return deleteVM(name, deleteVM, null);
	}

	public boolean deleteVM(String name, DeleteVM deleteVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteVM);
	}

	public boolean rebootVM(String name, RebootVM rebootVM) throws Exception {
		return rebootVM(name, rebootVM, null);
	}

	public boolean rebootVM(String name, RebootVM rebootVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), rebootVM);
	}

	public boolean plugNIC(String name, PlugNIC plugNIC) throws Exception {
		return plugNIC(name, plugNIC, null);
	}

	public boolean plugNIC(String name, PlugNIC plugNIC, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugNIC);
	}

	public boolean manageISO(String name, ManageISO manageISO) throws Exception {
		return manageISO(name, manageISO, null);
	}

	public boolean manageISO(String name, ManageISO manageISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), manageISO);
	}

	public boolean updateOS(String name, UpdateOS updateOS) throws Exception {
		return updateOS(name, updateOS, null);
	}

	public boolean updateOS(String name, UpdateOS updateOS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), updateOS);
	}

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage) throws Exception {
		return convertVMToImage(name, convertVMToImage, null);
	}

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), convertVMToImage);
	}

	public boolean insertISO(String name, InsertISO insertISO) throws Exception {
		return insertISO(name, insertISO, null);
	}

	public boolean insertISO(String name, InsertISO insertISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), insertISO);
	}

	public boolean ejectISO(String name, EjectISO ejectISO) throws Exception {
		return ejectISO(name, ejectISO, null);
	}

	public boolean ejectISO(String name, EjectISO ejectISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), ejectISO);
	}

	public boolean resizeVM(String name, ResizeVM resizeVM) throws Exception {
		return resizeVM(name, resizeVM, null);
	}

	public boolean resizeVM(String name, ResizeVM resizeVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeVM);
	}

	public boolean cloneVM(String name, CloneVM cloneVM) throws Exception {
		return cloneVM(name, cloneVM, null);
	}

	public boolean cloneVM(String name, CloneVM cloneVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), cloneVM);
	}

	public boolean bindPortVlan(String name, BindPortVlan bindPortVlan) throws Exception {
		return bindPortVlan(name, bindPortVlan, null);
	}

	public boolean bindPortVlan(String name, BindPortVlan bindPortVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), bindPortVlan);
	}

	public boolean unbindPortVlan(String name, UnbindPortVlan unbindPortVlan) throws Exception {
		return unbindPortVlan(name, unbindPortVlan, null);
	}

	public boolean unbindPortVlan(String name, UnbindPortVlan unbindPortVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unbindPortVlan);
	}
}
