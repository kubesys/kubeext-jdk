/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetwork;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePool;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AbstractTest {

	public static Config config = new ConfigBuilder()
			.withApiVersion("v1")
			.withCaCertData("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUN5RENDQWJDZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRFNU1UQXdNekV6TWpVeU5sb1hEVEk1TURrek1ERXpNalV5Tmxvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBTHFmCkZWeXZkREZkVmczTXYxR0lVbFRkL0hMUDE3bDFEUTJpK0hoS0IvQ1JtUlVjMzFGK2lidWxRYjdTNVIyMG1TdWQKeXBJcWY3Mzg3amJXZmV2c2FsK2xmcDBlaEZlNDZtV1ZVVlRPSVNJdlcyUHNla3d3Y0Q2KzV0THFVRlRGajBhYQozckt3N3JDS01VQXhCZ1p5QUhGWjI3T0VQWGJ0UlRmcTZKRURLeFhYTnlaMWhQNm16WVBCVHRwVFdUSnZIK1hXCk5aanR4SEpuN21FNHJld1AraVhhd2EwTmFQNlZTVFJucHdEeldVMURwQjdnN1dBd3dZSHJlNTIxeWVrTkdFa0cKOENZWXI4L3dqT1RjOEVDc1J4RER6Q3NNN254VEtwVHNTeHJQZzNoWEhLRURkTHVsNTlaRHVVczhZRmtqTzNyeQpxT3p2ZktUdVJ1VlVic09hWXljQ0F3RUFBYU1qTUNFd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFCazlmNERXRXRTUmNNNlNNNElVcGd6YVBPSUoKMGdjOXJaOTJ3ZVRteUk1MDRrdVJlcFhydGNtQzhvWE5OUmhmdGhYTkRveXpXaVJSNkVvc25uWi9YQ20ySldtVwpwN3daeHJidVZoNWkrckl6eTZSVExWZ2o3M0o1NGY5SnVCK2toeUMvcTgrSXpTS0puQnRnaWhnTTBrVXlXYzVXClhrN09UVXVOMFZRNnF6dW5nMkJSQjZ0aEFIQ2lWTWszd2kwRUt5N3A2a1ZJVktVSlVWdGpmeUU1ODhIaUtlcFUKK3VlWXRtT3JxWDBZN1JKUDdNbXowcFZDeCtnREtxZ0pBMXd2WEpJN2dqK3NwaVVkdUxzWmxSbzZlQTZFTnd3cgpYSzRyTktjRDA0SjM5aTBKZXphSnpXeDl3eWhTSTdTMXAxT0NRODhYbTJuMGwrYzh6aldrdnhVYzZPRT0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=")
			.withClientCertData("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM4akNDQWRxZ0F3SUJBZ0lJRkVZa3NaWkdwZmt3RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB4T1RFd01ETXhNekkxTWpaYUZ3MHlNREV3TURJeE16STFNelJhTURReApGekFWQmdOVkJBb1REbk41YzNSbGJUcHRZWE4wWlhKek1Sa3dGd1lEVlFRREV4QnJkV0psY201bGRHVnpMV0ZrCmJXbHVNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQTUySnNiNlpvNWdDaGZjemoKNTVxQUsrYmhxU2JLUWY2S2dYTlRYUzhkNStudEt4V1l2NXBMV0g0Z3pwMjdRRmNhME9TMUxYM2J1MlArR2ZUagpQY0JCbWpic2VnV2hLMmNEamdrdXk5eXdBeGROWWNvenB0akF4QmhuQ01wbWg0TE84Wk9mcUFYQVlyYjBvc2hmCitsMjc3YjRnSzdHbmw1b2JCUmtTdkNqK1pRQU9mQ1ZiU1AvRWpSa3FGdWdpeWcyampxWXBIOHlQaFNRcmR3Q3MKUjVKWmZaWllOUnBacnNMRlg3M1JwMDIrMEVkb1NwblhrS28yWWROT0NTUVJ0dXFPR1RrUnFsMFVaYno0NTZoUQowL2V5cXZGd3hacVZlaWxmZ3BzaDRCTkVlcm03aW1OM043NlJPMUdpaWxnS05FSG8weXVrRW52aWk1Q1B1SVhiCnVKNjZOd0lEQVFBQm95Y3dKVEFPQmdOVkhROEJBZjhFQkFNQ0JhQXdFd1lEVlIwbEJBd3dDZ1lJS3dZQkJRVUgKQXdJd0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFGMGNNQUtvNmUyNzJOZ2ZyVVlTYmxRMnh5cWtCaURnbHdvZwprMzdqaDJCRlFodFZOTUZNajhFQ3ZJVEM1QmdQV0UvalRtWDRoV0t5eFFpU1FzaDNYUGJtdlhjTC9saDFHS2l1CjNrTlJWRlZYWFhxNTZXdzBNWFVhM0NkTFkxcVNQcENvUldoeVNtSi94TTNWRmxlQ0F5NGppQkhZencrT1ZHdjkKTEd5TWljVlV3RGZLcDJabytHa1Z6VlV4Q3lJV1RzbU5EYUhvRDJuMkxZNm1YVlFsUTh5MkJEVXZLbWNUNm5rUAphQlFiUlpKYWFmYnRrNHNwQ2twUDI0RGtZREd5M0tnblg3OTg3NVYwY2VjTlFIS1hGc2xQbzduNjIwUktiOU1VCkhBTk1Za29jZkRyK1pvM29pRnhCbUZXVkdMZ2Y4UUJqMmdYYk1BNnRpS29US1BhTi81cz0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=")
			.withClientKeyData("LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFb2dJQkFBS0NBUUVBNTJKc2I2Wm81Z0NoZmN6ajU1cUFLK2JocVNiS1FmNktnWE5UWFM4ZDUrbnRLeFdZCnY1cExXSDRnenAyN1FGY2EwT1MxTFgzYnUyUCtHZlRqUGNCQm1qYnNlZ1doSzJjRGpna3V5OXl3QXhkTlljb3oKcHRqQXhCaG5DTXBtaDRMTzhaT2ZxQVhBWXJiMG9zaGYrbDI3N2I0Z0s3R25sNW9iQlJrU3ZDaitaUUFPZkNWYgpTUC9FalJrcUZ1Z2l5ZzJqanFZcEg4eVBoU1FyZHdDc1I1SlpmWlpZTlJwWnJzTEZYNzNScDAyKzBFZG9TcG5YCmtLbzJZZE5PQ1NRUnR1cU9HVGtScWwwVVpiejQ1NmhRMC9leXF2Rnd4WnFWZWlsZmdwc2g0Qk5FZXJtN2ltTjMKTjc2Uk8xR2lpbGdLTkVIbzB5dWtFbnZpaTVDUHVJWGJ1SjY2TndJREFRQUJBb0lCQVFDdnJxdG1tcE5MRDIrTwpkT01XRnRqNmZITWFXN2wySWk1SDI2aVFPQlljNENDVGRmSmtpR0pzN2xjNmljaURNWi9LdTl4VWpoc29UT1BDCkVZMzRkT0ZhbGhrM0RNOHloU1ROMDJzVW5wdUZ2VXVqMUVNamk2L1JORFlIRnFhQ2ZXOWpQUk1jSUVIU3NkZE4KUVphZUlrMXVWYzFYWDZ4QUQySTBuTFQ4NktNL1N6b1h5aVRhem03WG8rQkI2aE1nL1JMZExuUEFFZXIxTHU5TgpJSVZSTXZmb01YaTRPcmJIZnBERjREYWJraVl3aEpHOGpSL3doU25UNEdmRWJpMVFRdzE4T2xQd05qL3ZmTUFjCjJSd2NvVUFZd2p4WWhFUzZ5bUhqZ2RZOUttbXdIM3JvbzFtRnhkOW9KTFU5dE4vb1gyMExwUHBjVDgrYWp3ZzMKYm5Kc01Sd0JBb0dCQVBDbGU1NUYwMkV1bHdYek9qOUlhWUczNDAwK3NuZDZyYjhDc0d6MjlOYXRNTVJNUm82aApmS0ZQNHJQaUFoQTNlYU51SlBMbXp2REZCNDBhS3RvVU5ZWkU1L1BNbGtlT3pITTcwdXExUmpKMm8vZnNBcStBCmU4VnhZL1FONVVvWW9wYi9pU0JZNyt0ZHlsY05ieVo2Y0I0ZVlYV2FEanB2SXF4VlpYSEhNRHJ4QW9HQkFQWWwKcWV1VHlMeTdiWnFrc2ptM09pdzllOUR3WWlVc3ZMS2JhZi9YVW82eE84SEttWm43RGdxdm45NFVtak9hdVZmZQp4RzE3dTl0TUV3K2FFM2VGSjNYT1daZ2g0WTFEU0lUaGliU0pZeWRWdGVkWUJyVnFDdmJZNUpFWkljS2FCSHVYCkMyTlYxb1lGQk1HdUZRWFJoNWtZZG9TNjR2b0xKbXluMDFEeVpyZW5Bb0dCQUt1cllhUm02NFJJV0RSR2J5YjEKNFU1SWdENTZtNVhnVGxJVStRYkNwYWIvcGVwaS8zS0FnUWdTbFFiK0U3cTkyR2hlQ3IyOUthTlk2eW9kb0xReAo5bnp5YXdYZ3pOUC9hcHBKOHd5OGhIYzdhMzFSUUJreTd4aks2eU1QUnFLMU1FZkh3MnJ3QnpkQWtUZkl2YUlWCmRpWUdSa0EreGllcFlITFArSzVTQ25ZQkFvR0FlS0JxamtWRlNhQjhqUjJMTGhlcURZWXdDR3ZWWFN4NGFQc2EKemtOQ2RTVk1DS04xOU8wQXE2SDNzWWpkTE03MVo2ZUhFYlJpa296TWhvZldaR3MvdEU3a3YxWlRSN3dpYk9SdQpiS2dyakZwSG85RVNzSk1BUG9wNk1OVmxJdzRCaG1PMk0vOGIrMSs0UGdaR3pTd3F6SThkZmR4c1lXZFhkRVltCm0vTysvTjhDZnpYL2lya1hrcnVDUVU2aHRvRFJybVAyWXNvWkFUWU5NOEVRcldORVZ4T252OUthd3lKY1kxYzQKaC85Y0dCdE1vRFhkbWNOcGZnNzFNUkl3Nm1wNjFVRWlHSlpvc2ZiOFZLWXV0Y3Y2eGFCZ2cwRUdVYkM4eVJrLwpoaXFjNFhFaGV6cFdYbVlUSlhkZGwvMEFSRmo3alpBelJQYWVvSUlNKzJiRUlncHc2SFU9Ci0tLS0tRU5EIFJTQSBQUklWQVRFIEtFWS0tLS0tCg=")
			.withMasterUrl("https://133.133.135.35:6443")
			.build();
	
	public static ExtendedKubernetesClient getClient() throws Exception {
		return new ExtendedKubernetesClient(config);
	}
	
	public static VirtualMachine getVMByName(String name) throws Exception {
		return getClient().virtualMachines().get(name);
	}
	
	public static VirtualMachineImage getVMImageByName(String name) throws Exception {
		return getClient().virtualMachineImages().get(name);
	}
	
	public static VirtualMachineDisk getVMDiskByName(String name) throws Exception {
		return getClient().virtualMachineDisks().get(name);
	}
	
	public static VirtualMachinePool getVMPoolByName(String name) throws Exception {
		return getClient().virtualMachinePools().get(name);
	}
	
	public static VirtualMachineDiskImage getVMDiskImageByName(String name) throws Exception {
		return getClient().virtualMachineDiskImages().get(name);
	}
	
	public static VirtualMachineNetwork getVMNetworkByName(String name) throws Exception {
		return getClient().virtualMachineNetworks().get(name);
	}

}