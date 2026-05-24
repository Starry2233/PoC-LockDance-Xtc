# PoC-LockDance-Xtc

[![Android CI](https://github.com/Starry2233/PoC-LockDance-Xtc/actions/workflows/android.yml/badge.svg)](https://github.com/Starry2233/PoC-LockDance-Xtc/actions/workflows/android.yml)

> **锁屏密码绕过 / 永久锁机 PoC**  
> **Screen Lock Password Bypass / Permanent Lockout PoC**

---

## 概述 / Overview

**中文**  
本 PoC 演示了小天才电话手表 Z8A 系统预装应用 `com.xtc.i3launcher` 中存在的无权限校验 Broadcast Receiver 漏洞。恶意应用可通过发送特定 Intent 来设置或清除设备的锁屏密码，无需任何用户交互或特殊权限，导致：

- 设备被设置未知密码 → **永久锁死**，用户只能双清（数据全丢）
- 攻击者知道密码 → **完全访问设备上的所有用户数据**

**English**  
This PoC demonstrates an unprotected Broadcast Receiver vulnerability in the pre-installed system application `com.xtc.i3launcher` on 小天才 (Xiaotiancai/imoo) Z8A smartwatch. A malicious app can set or clear the device's screen lock password by sending crafted Intents without any user interaction or special permissions, resulting in:

- Permanent device lockout (factory reset required, all data lost)
- Unauthorized access to all user data stored on the device

---

## 漏洞详情 / Vulnerability Details

- **CVE**: 申请中 / Pending
- **CVSS 预估评分 / Estimated Score**: 8.6 (AV:L/AC:L/PR:L/UI:N/S:C/C:H/I:H/A:H) — CVSS:3.1（等待官方审核 / pending official assessment）
- **漏洞类型 / Type**: Incorrect Access Control / Unprotected Broadcast Receiver
- **受影响组件 / Affected Component**: `com.xtc.i3launcher` (system launcher)
- **受影响的 Action / Affected Actions**:
  - `com.xtc.dial.ACTION.SCREEN_PASSWORD_SET`
  - `com.xtc.dial.ACTION.SCREEN_PASSWORD_RESET`
- **受影响的设备 / Affected Devices**: 小天才电话手表 Z8A (及其他搭载相同固件的设备 / and other devices with the same firmware)
- **厂商 / Vendor**: 广东小天才科技有限公司 (Guangdong Genius Technology Co., Ltd.)

---

## 演示 / Demo

![Demo](result.gif)

---

## 构建 & 安装 / Build & Install

```bash
# 构建 Debug APK / Build Debug APK
./gradlew assembleDebug

# APK 路径 / Output path:
# app/build/outputs/apk/debug/app-debug.apk
```

下载构建产物 / Download pre-built APK: [Actions 页面 / Actions Tab](https://github.com/Starry2233/PoC-LockDance-Xtc/actions)

---

## 攻击流程 / Attack Flow

**中文**
1. 恶意 App 安装到设备上（通过应用商店分发）
2. App 在后台发送 Intent 到 `com.xtc.i3launcher`
3. 系统锁屏密码被静默设置为 `1111`
4. 用户被锁在设备外，或攻击者用已知密码解锁窃取数据

**English**
1. Malicious app is installed on the device (distributed via app store)
2. App sends crafted Intent to `com.xtc.i3launcher` in the background
3. Screen lock password is silently changed to `1111`
4. User is locked out, or attacker unlocks the device with the known password

---

## 影响 / Impact

- **机密性 / Confidentiality**: 攻击者可解锁设备获取全部数据 / Attacker can unlock and access all device data
- **完整性 / Integrity**: 锁屏密码被篡改 / Screen lock password is modified
- **可用性 / Availability**: 设备永久锁死，只能双清恢复（数据全损） / Permanent device lockout, factory reset required (data loss)

---

## 时间线 / Timeline

| 日期 / Date | 事件 / Event |
|-------------|-------------|
| 2026-05-24 | 漏洞发现 / Vulnerability discovered |
| 2026-05-24 | CVE 提交 / CVE requested (MCID15773937) |


---

## 免责声明 / Disclaimer

**中文**  
本 PoC 仅用于安全研究和教育目的。未经设备所有者明确同意，请勿在未经授权的设备上使用。

**English**  
This PoC is for educational and security research purposes only. Do not use on unauthorized devices without explicit consent from the device owner.
