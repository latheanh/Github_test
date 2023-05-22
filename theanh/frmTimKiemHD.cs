using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using QuanLyBanHang.Class;

namespace QuanLyBanHang
{
    public partial class frmTimKiemHD : Form
    {
        DataTable tblHDBan;
        public frmTimKiemHD()
        {
            InitializeComponent();
        }

        private void lable4_Click(object sender, EventArgs e)
        {

        }

        private void frmTimKiemHD_Load(object sender, EventArgs e)
        {
            ResetValues();
            dgvDanhSachHD.DataSource = null;
        }
        private void ResetValues()
        {
            foreach (Control Ctl in this.Controls)
                if (Ctl is TextBox)
                    Ctl.Text = "";
            txtMaHoaDon.Focus();
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {
            string sql;
            if ((txtMaHoaDon.Text == "") && (txtThang.Text == "") && (txtNam.Text == "") &&
               (txtMaNhanVien.Text == "") && (txtMaKhachHang.Text == "") &&
               (txtTongTien.Text == ""))
            {
                MessageBox.Show("Hãy nhập một điều kiện tìm kiếm!!!", "Yêu cầu ...", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            sql = "SELECT * FROM tblHDBan WHERE 1=1";
            if (txtMaHoaDon.Text != "")
                sql = sql + " AND MaHDBan Like N'%" + txtMaHoaDon.Text + "%'";
            if (txtThang.Text != "")
                sql = sql + " AND MONTH(NgayBan) =" + txtThang.Text;
            if (txtNam.Text != "")
                sql = sql + " AND YEAR(NgayBan) =" + txtNam.Text;
            if (txtMaNhanVien.Text != "")
                sql = sql + " AND MaNhanVien Like N'%" + txtMaNhanVien.Text + "%'";
            if (txtMaKhachHang.Text != "")
                sql = sql + " AND MaKhach Like N'%" + txtMaKhachHang.Text + "%'";
            if (txtTongTien.Text != "")
                sql = sql + " AND TongTien <=" + txtTongTien.Text;
            tblHDBan = Functions.GetDataToTable(sql);
            if (tblHDBan.Rows.Count == 0)
            {
                MessageBox.Show("Không có bản ghi thỏa mãn điều kiện!!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
                MessageBox.Show("Có " + tblHDBan.Rows.Count + " bản ghi thỏa mãn điều kiện!", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            dgvDanhSachHD.DataSource = tblHDBan;
            LoadDataGridView();
        }
        private void LoadDataGridView()
        {
            dgvDanhSachHD.Columns[0].HeaderText = "Mã HĐB";
            dgvDanhSachHD.Columns[1].HeaderText = "Mã nhân viên";
            dgvDanhSachHD.Columns[2].HeaderText = "Ngày bán";
            dgvDanhSachHD.Columns[3].HeaderText = "Mã khách";
            dgvDanhSachHD.Columns[4].HeaderText = "Tổng tiền";
            dgvDanhSachHD.Columns[0].Width = 150;
            dgvDanhSachHD.Columns[1].Width = 100;
            dgvDanhSachHD.Columns[2].Width = 80;
            dgvDanhSachHD.Columns[3].Width = 80;
            dgvDanhSachHD.Columns[4].Width = 80;
            dgvDanhSachHD.AllowUserToAddRows = false;
            dgvDanhSachHD.EditMode = DataGridViewEditMode.EditProgrammatically;
        }

        private void btnTimLai_Click(object sender, EventArgs e)
        {
            ResetValues();
            dgvDanhSachHD.DataSource = null;
        }

        private void txtTongTien_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (((e.KeyChar >= '0') && (e.KeyChar <= '9')) || (Convert.ToInt32(e.KeyChar) == 8))
                e.Handled = false;
            else
                e.Handled = true;
        }

        private void dgvDanhSachHD_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            string mahd;
            if (MessageBox.Show("Bạn có muốn hiển thị thông tin chi tiết?", "Xác nhận", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                mahd = dgvDanhSachHD.CurrentRow.Cells["MaHDBan"].Value.ToString();
                frmHoaDonBan frm = new frmHoaDonBan();
                frm.txtMaHDBan.Text = mahd;
                frm.StartPosition = FormStartPosition.CenterParent;
                frm.ShowDialog();
            }
        }

        private void btnDong_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
